package org.fsoft.tms.controller;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.repository.CourseRepository;
import org.fsoft.tms.repository.TopicRepository;
import org.fsoft.tms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 5/27/2017.
 */
@Controller
@RequestMapping(value = "/staff/topic")
public class TopicController {

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @Autowired
    UserPropertyService userPropertyService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    TopicService topicService;

    @Autowired
    MailSender mailSender;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listTopic", topicService.getAllTopicByStaff());
        return "topic/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAdd(Model model) {
        model.addAttribute("topic", new Topic());
        model.addAttribute("listCourse", courseService.getAllCourseByStaff());
        return "topic/add";
    }

    @RequestMapping(value = "/addTopic")
    public String getPageAdd(@ModelAttribute Topic topic) {
        topic.setActive(true);
        topicService.addTopic(topic);
        return "redirect:/staff/topic/";
    }

    @RequestMapping(value = "/update/{id}")
    public String getPageAdd(@PathVariable String id, Model model) {
        Topic topic = topicService.finOneById(Integer.parseInt(id));
        model.addAttribute("topic", topic);
        return "topic/update";
    }

    @RequestMapping(value = "/updateTopic")
    public String update(@ModelAttribute Topic topic) {
        topicService.updateTopic(topic);
        return "redirect:/staff/topic/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String getPageDelete(@PathVariable String id) {
        topicService.deleteTopic(Integer.parseInt(id));
        return "redirect:/staff/topic/";
    }

    @RequestMapping(value = "/trainer/{id}")
    public String addTrainer(@PathVariable String id, Model model) {
        model.addAttribute("topic", topicService.finOneById(Integer.parseInt(id)));
        List<User> arr =  userService.getAllUserByRoleAndManager(3, 1);
        model.addAttribute("listTrainer", arr);
        System.out.println("size: " + arr.size());
        return "topic/addtrainer";
    }

//    @RequestMapping(value = "/trainer/{trainerID}/{topicID}")
//    public String adđTrainer1ToTopic(@PathVariable("trainerID") String trainerID, @PathVariable("topicID") String topicID, Model model) {
//        topicService.addTrainerToTopic(Integer.parseInt(topicID), Integer.parseInt(trainerID));
//        return "redirect:/staff/topic/";
//    }

    @RequestMapping(value="/trainer/{trainerID}/{topicID}")
    public String adđTrainerToTopic(@PathVariable("trainerID") String trainerID, @PathVariable("topicID") String topicID, Model model) {
        topicService.addTrainerToTopic(Integer.parseInt(topicID), Integer.parseInt(trainerID));
        String email = userPropertyService.getUserProperty(userService.findOneUser(Integer.parseInt(trainerID)), propertyService.findOneProperty(10)).getValue();
        Topic t = topicService.finOneById(Integer.parseInt(topicID));
        SimpleMailMessage message=new SimpleMailMessage();
        Date date=new Date();
        message.setSubject("Tài khoản của bạn tại hệ thống TMS đã được tạo");
        message.setText("Xin chào bạn, đây là mail tự động được gửi vào lúc "+date.toLocaleString()
                +" từ hệ thống TMS nhằm thông báo về việc tài khoản của bạn đã được add vào topic tạo với thông tin như sau: \n" +
                "Tên topic: "+ t.getTitle()+" "
                +"Xin chân thành cảm ơn\n" +
                "Lưu ý: Đây là hộp thư tự động, bạn không cần trả lời email này");
        message.setTo(email);
        //input into parameter in method setFrom same as variable spring.mail.username in file application.properties
        message.setFrom("email");
        try{
            mailSender.send(message);
        }catch (Exception ex){
            mailSender.send(message);
            ex.printStackTrace();
        }
        return "redirect:/staff/topic/";
    }
}
