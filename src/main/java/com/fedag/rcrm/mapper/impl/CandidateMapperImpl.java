//package com.fedag.rcrm.mapper.impl;
//
//import com.fedag.rcrm.model.CandidateModel;
//import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
//import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
//import org.mapstruct.Mapping;
//
//public class CandidateMapperImpl {
//
//    public CandidateModel toModel(CandidateRequestDto candidateDto) {
//        if ( candidateDto == null ) {
//            return null;
//        }
//        CandidateModel candidateModel = new CandidateModel();
//
//        candidateModel.setPhoneNumber( candidateDto.getPhoneNumber() );
//        candidateModel.setEmail( candidateDto.getEmail() );
//        candidateModel.setResidence( candidateDto.getResidence() );
//        candidateModel.setCountry( candidateDto.getCountry() );
//        candidateModel.setCity( candidateDto.getCity() );
//        candidateModel.setPosition( candidateDto.getPosition() );
//        candidateModel.setSalary( candidateDto.getSalary() );
//        candidateModel.setBirthdate( candidateDto.getBirthdate() );
//        candidateModel.setCreationDate( candidateDto.getCreationDate() );
//        candidateModel.setHr( hRDtoToHRModel( candidateDto.getHr() ) );
//        candidateModel.setStatus( candidateDto.getStatus() );
//        candidateModel.setTotalRating( candidateDto.getTotalRating() );
//        candidateModel.setCvLink( candidateDto.getCvLink() );
//        candidateModel.setVacancy( vacancyDtoToVacancyModel( candidateDto.getVacancy() ) );
//
//        return candidateModel;
//    }
//
//    public CandidateRequestDto toRequestDto(CandidateModel candidateModel) {
//
//    }
//
//    public CandidateResponseDto toResponseDto(CandidateModel candidateModel) {
//
//    }
//}
///*
//
//    @Override
//    public CandidateDto toDto(CandidateModel candidateModel, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
//        CandidateDto target = cycleAvoidingMappingContext.getMappedInstance( candidateModel, CandidateDto.class );
//        if ( target != null ) {
//            return target;
//        }
//
//        if ( candidateModel == null ) {
//            return null;
//        }
//
//        CandidateDto candidateDto = new CandidateDto();
//
//        cycleAvoidingMappingContext.storeMappedInstance( candidateModel, candidateDto );
//
//        candidateDto.setExperienceOfWorksListDto( experienceOfWorkModelListToExperienceOfWorkDtoList( candidateModel.getExperienceOfWorksList(), cycleAvoidingMappingContext ) );
//        candidateDto.setFeedbackDto( feedbackModelListToFeedbackDtoList( candidateModel.getFeedback(), cycleAvoidingMappingContext ) );
//        candidateDto.setPhoneNumber( candidateModel.getPhoneNumber() );
//        candidateDto.setEmail( candidateModel.getEmail() );
//        candidateDto.setResidence( candidateModel.getResidence() );
//        candidateDto.setCountry( candidateModel.getCountry() );
//        candidateDto.setCity( candidateModel.getCity() );
//        candidateDto.setPosition( candidateModel.getPosition() );
//        candidateDto.setSalary( candidateModel.getSalary() );
//        candidateDto.setBirthdate( candidateModel.getBirthdate() );
//        candidateDto.setCreationDate( candidateModel.getCreationDate() );
//        candidateDto.setHr( hRModelToHRDto( candidateModel.getHr(), cycleAvoidingMappingContext ) );
//        candidateDto.setStatus( candidateModel.getStatus() );
//        candidateDto.setTotalRating( candidateModel.getTotalRating() );
//        candidateDto.setCvLink( candidateModel.getCvLink() );
//        candidateDto.setVacancy( vacancyModelToVacancyDto( candidateModel.getVacancy(), cycleAvoidingMappingContext ) );
//
//        return candidateDto;
//    }
//
//    protected VacancyModel vacancyDtoToVacancyModel(VacancyDto vacancyDto) {
//        if ( vacancyDto == null ) {
//            return null;
//        }
//
//        VacancyModel vacancyModel = new VacancyModel();
//
//        vacancyModel.setTitle( vacancyDto.getTitle() );
//        vacancyModel.setPosition( vacancyDto.getPosition() );
//        vacancyModel.setSalary( vacancyDto.getSalary() );
//        vacancyModel.setCreationDate( vacancyDto.getCreationDate() );
//        vacancyModel.setComment( vacancyDto.getComment() );
//        vacancyModel.setDescription( vacancyDto.getDescription() );
//        vacancyModel.setStatus( vacancyDto.getStatus() );
//
//        return vacancyModel;
//    }
//
//    protected List<VacancyModel> vacancyDtoListToVacancyModelList(List<VacancyDto> list) {
//        if ( list == null ) {
//            return null;
//        }
//
//        List<VacancyModel> list1 = new ArrayList<VacancyModel>( list.size() );
//        for ( VacancyDto vacancyDto : list ) {
//            list1.add( vacancyDtoToVacancyModel( vacancyDto ) );
//        }
//
//        return list1;
//    }
//
//    protected HRModel hRDtoToHRModel(HRDto hRDto) {
//        if ( hRDto == null ) {
//            return null;
//        }
//
//        HRModel hRModel = new HRModel();
//
//        hRModel.setLogin( hRDto.getLogin() );
//        char[] password = hRDto.getPassword();
//        if ( password != null ) {
//            hRModel.setPassword( Arrays.copyOf( password, password.length ) );
//        }
//        Set<Role> set = hRDto.getRoles();
//        if ( set != null ) {
//            hRModel.setRoles( new LinkedHashSet<Role>( set ) );
//        }
//        hRModel.setCreationDate( hRDto.getCreationDate() );
//        hRModel.setVacancies( vacancyDtoListToVacancyModelList( hRDto.getVacancies() ) );
//
//        return hRModel;
//    }
//
//    protected List<ExperienceOfWorkDto> experienceOfWorkModelListToExperienceOfWorkDtoList(List<ExperienceOfWorkModel> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
//        List<ExperienceOfWorkDto> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
//        if ( target != null ) {
//            return target;
//        }
//
//        if ( list == null ) {
//            return null;
//        }
//
//        List<ExperienceOfWorkDto> list1 = new ArrayList<ExperienceOfWorkDto>( list.size() );
//        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );
//
//        for ( ExperienceOfWorkModel experienceOfWorkModel : list ) {
//            list1.add( experienceOfWorkMapper.toDto( experienceOfWorkModel, cycleAvoidingMappingContext ) );
//        }
//
//        return list1;
//    }
//
//    protected List<FeedbackDto> feedbackModelListToFeedbackDtoList(List<FeedbackModel> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
//        List<FeedbackDto> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
//        if ( target != null ) {
//            return target;
//        }
//
//        if ( list == null ) {
//            return null;
//        }
//
//        List<FeedbackDto> list1 = new ArrayList<FeedbackDto>( list.size() );
//        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );
//
//        for ( FeedbackModel feedbackModel : list ) {
//            list1.add( feedbackMapper.toFeedbackDto( feedbackModel, cycleAvoidingMappingContext ) );
//        }
//
//        return list1;
//    }
//
//    protected VacancyDto vacancyModelToVacancyDto(VacancyModel vacancyModel, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
//        VacancyDto target = cycleAvoidingMappingContext.getMappedInstance( vacancyModel, VacancyDto.class );
//        if ( target != null ) {
//            return target;
//        }
//
//        if ( vacancyModel == null ) {
//            return null;
//        }
//
//        VacancyDto vacancyDto = new VacancyDto();
//
//        cycleAvoidingMappingContext.storeMappedInstance( vacancyModel, vacancyDto );
//
//        vacancyDto.setTitle( vacancyModel.getTitle() );
//        vacancyDto.setPosition( vacancyModel.getPosition() );
//        vacancyDto.setSalary( vacancyModel.getSalary() );
//        vacancyDto.setCreationDate( vacancyModel.getCreationDate() );
//        vacancyDto.setComment( vacancyModel.getComment() );
//        vacancyDto.setDescription( vacancyModel.getDescription() );
//        vacancyDto.setStatus( vacancyModel.getStatus() );
//
//        return vacancyDto;
//    }
//
//    protected List<VacancyDto> vacancyModelListToVacancyDtoList(List<VacancyModel> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
//        List<VacancyDto> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
//        if ( target != null ) {
//            return target;
//        }
//
//        if ( list == null ) {
//            return null;
//        }
//
//        List<VacancyDto> list1 = new ArrayList<VacancyDto>( list.size() );
//        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );
//
//        for ( VacancyModel vacancyModel : list ) {
//            list1.add( vacancyModelToVacancyDto( vacancyModel, cycleAvoidingMappingContext ) );
//        }
//
//        return list1;
//    }
//
//    protected HRDto hRModelToHRDto(HRModel hRModel, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
//        HRDto target = cycleAvoidingMappingContext.getMappedInstance( hRModel, HRDto.class );
//        if ( target != null ) {
//            return target;
//        }
//
//        if ( hRModel == null ) {
//            return null;
//        }
//
//        HRDto hRDto = new HRDto();
//
//        cycleAvoidingMappingContext.storeMappedInstance( hRModel, hRDto );
//
//        hRDto.setLogin( hRModel.getLogin() );
//        char[] password = hRModel.getPassword();
//        if ( password != null ) {
//            hRDto.setPassword( Arrays.copyOf( password, password.length ) );
//        }
//        Set<Role> set = hRModel.getRoles();
//        if ( set != null ) {
//            hRDto.setRoles( new LinkedHashSet<Role>( set ) );
//        }
//        hRDto.setCreationDate( hRModel.getCreationDate() );
//        hRDto.setVacancies( vacancyModelListToVacancyDtoList( hRModel.getVacancies(), cycleAvoidingMappingContext ) );
//
//        return hRDto;
//    }
//}
//
// */
