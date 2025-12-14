package co.yuno.YunoTalkTrack.domain.service;


import co.yuno.YunoTalkTrack.persistence.entity.*;
import co.yuno.YunoTalkTrack.persistence.entity.raw.FillTable;
import co.yuno.YunoTalkTrack.persistence.crud.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class FillTableProcessorService {

    private final UserJpaRepository userRepository;
    private final ProjectJpaRepository projectRepository;
    private final MerchantJpaRepository merchantRepository;
    private final ProjectInfoRepository projectInfoRepository;
    private final MeetingJpaRepository meetingRepository;

    public FillTableProcessorService(UserJpaRepository userRepository,
                                     ProjectJpaRepository projectRepository,
                                     MerchantJpaRepository merchantRepository,
                                     ProjectInfoRepository projectInfoRepository,
                                     MeetingJpaRepository meetingRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.merchantRepository = merchantRepository;
        this.projectInfoRepository = projectInfoRepository;
        this.meetingRepository = meetingRepository;
    }

    @Transactional
    public void processFillTable(FillTable fill) {
        LocalDateTime now = LocalDateTime.now();

        // 1) Buscar usuario por userName (ignore case)
        User user = userRepository.findByNameIgnoreCase(fill.getUserName())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Usuario no encontrado para userName=" + fill.getUserName()));

        // 2) Buscar proyecto por projectName (ignore case)
        Project project = projectRepository.findByNameIgnoreCase(fill.getProjectName())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Proyecto no encontrado para projectName=" + fill.getProjectName()));

        // 3) Buscar merchant por merchantName + isoCode
        Merchant merchant = merchantRepository.findByNameIgnoreCaseAndCountryMerchants_Country_IsoCode(fill.getMerchantName(), fill.getIsoCode())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Merchant no encontrado para merchantName=" + fill.getMerchantName()
                                + " e isoCode=" + fill.getIsoCode()));

        // Nos aseguramos de que el proyecto tenga ese merchant (si aplica a tu modelo)
        project.setMerchant(merchant);

        // 4) Crear ProjectInfo
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setProject(project);
        projectInfo.setDescription(fill.getContent()); // description <- content
        projectInfo.setPhase(project.getProjectPhase()); // o null, o lógica que quieras
        projectInfo.setCreatedBy(user);                 // created_by <- userName
        projectInfo.setCreatedAt(now);                 // fecha actual
        projectInfo.setParentInfo(null);

        projectInfo = projectInfoRepository.save(projectInfo);

        // 5) Crear Meeting asociado a ese ProjectInfo
        Meeting meeting = new Meeting();
        meeting.setProjectInfo(projectInfo);
        meeting.setInfoSource(fill.getInfoSource());  // infoSource <- fill.type
        meeting.setSummary(fill.getContent());        // summary <- content
        meeting.setDate(now);                         // fecha actual

        meetingRepository.save(meeting);
    }
}
