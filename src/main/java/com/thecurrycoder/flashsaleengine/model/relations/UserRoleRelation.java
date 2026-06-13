package com.thecurrycoder.flashsaleengine.model.relations;

import com.thecurrycoder.flashsaleengine.model.Role;
import com.thecurrycoder.flashsaleengine.model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user_role_relation")
@Data
public class UserRoleRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}