package com.fedag.rcrm.security;

import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService {
//    @Value("${host.url}")
//    private String hostURL;
//    @Value("${server.port}")
//    private String portURL;
//    private final HRRepo hrRepo;
//    private final JwtTokenProvider jwtTokenProvider;
////    private final CompanyRepository companyRepository;
////    private final MailSendlerService mailSendler;
//    @Value("${activation.url}")
//    private String activationURL;
//
//
//    public boolean isUserInActiveState(String login) {
//        HRModel hrModel = hrRepo.findByLogin(login).orElse(null);
//        if (hrModel == null) {
//            return false;
//        }
//        return !hrModel.getRole().equals(Role.ADMIN_INACTIVE)
//                && !hrModel.getRole().equals(Role.USER_INACTIVE);
//    }
//
////    public boolean isCompanyInActiveState(String email) {
////        Company company = companyRepository.findByEmail(email).orElse(null);
////        if (company == null) {
////            return false;
////        }
////        return !company.getRole().equals(Role.ADMIN_INACTIVE)
////                && !company.getRole().equals(Role.USER_INACTIVE);
////    }
//
////    public String definitionToken(String email) {
////        String token;
////        Optional<Company> optionalCompany = companyRepository.findByEmail(email);
////        if (optionalCompany.isPresent()) {
////            Company company = optionalCompany.get();
////            token = jwtTokenProvider.createToken(email, company.getRole().name());
////            if (company.getActivationCode() != null) {
////                sentMessage(company.getName(), company.getEmail(), company.getActivationCode(),
////                        "company");
////                throw new ActivationException("Email not confirm. " +
////                        "A letter has been re-sent to your email address.");
////            }
////        } else {
////            User user = hrRepo.findByEmail(email).orElseThrow(
////                    () -> new UsernameNotFoundException("User doesn't exists"));
////            if (user.getActivationCode() != null) {
////                sentMessage(user.getFirstname(), user.getEmail(), user.getActivationCode(),
////                        "user");
////                throw new ActivationException("Email not confirm. " +
////                        "A letter has been re-sent to your email address");
////            }
////            token = jwtTokenProvider.createToken(email, user.getRole().name());
////        }
////        return token;
////    }
//
//    public void sentMessage(String name, String email, String activationCode, String entity) {
//        String link = String.format("%s:%s%s%s/%s", hostURL, portURL, activationURL, entity, activationCode);
//        String message = String.format("<h1>Hello, %s</h1> \n" +
//                        "<div>Welcome to FedAG!</div>" +
//                        "<div>To activate your account, follow the link:</div><a href=%s>%s</a>",
//                name, link, link);
//        try {
//            mailSendler.sendHtmlEmail(email, "Activation code", message);
//        } catch (MessagingException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Activation is failed");
//        }
//    }
//
//    public ResponseEntity<?> responseToReactivateAccount(String email) {
//        String link = String.format("%s:%s/api/activate/restore/%s", hostURL, portURL, email);
//        String message = String.format("<div>Your account is disabled.\n" +
//                "Please follow the link to restore it:</div>" +
//                "<a href=%s>%s</a>", link, link);
//        try {
//            mailSendler.sendHtmlEmail(email, "Restore account", message);
//        } catch (MessagingException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restore is failed");
//        }
//        return new ResponseEntity<>("Account is disabled. Check your email to enable it.",
//                HttpStatus.FORBIDDEN);
//    }
//
//    public ResponseEntity<?> reactivateAccount(String email) {
//        Optional<Company> optionalCompany = companyRepository.findByEmail(email);
//        if (optionalCompany.isPresent()) {
//            Company company = optionalCompany.get();
//            company.setRole(MainUtilites.switchRoleToOpposite(company.getRole()));
//            companyRepository.save(company);
//            return new ResponseEntity<>("Company set to active state successfully.", HttpStatus.OK);
//        } else {
//            User user = hrRepo.findByEmail(email).orElseThrow(
//                    () -> new UsernameNotFoundException("User doesn't exists"));
//            user.setRole(MainUtilites.switchRoleToOpposite(user.getRole()));
//            hrRepo.save(user);
//            return new ResponseEntity<>("User set to active state successfully.", HttpStatus.OK);
//        }
//    }
}
