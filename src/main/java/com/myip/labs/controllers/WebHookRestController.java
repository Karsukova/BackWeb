package com.myip.labs.controllers;

import com.myip.labs.entity.VkGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vk")
public class WebHookRestController {
    @Value("${vk.webhook.type}")
    private String type;
    @Value("${vk.webhook.group_id}")
    private Long group_id;
    @Value("${vk.webhook.response}")
    private String response;

    @PostMapping("/callback")
    public ResponseEntity<String> checkToConfirmation(@RequestBody VkGroup vkGroup) {
        if(type.equals(vkGroup.getType()) && (group_id.equals(vkGroup.getGroup_id()))){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body("Bad request");
    }
}
