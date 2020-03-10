package Belousov;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class User {

    private String name;
    private Roles role;

    public User(String nameC, Roles roleC){
        this.name = nameC;
        this.role = roleC;
    }

    public void hellowUser(){
        HashMap<Roles,String> rolesUsers = new HashMap<>();
        rolesUsers.put(Roles.ADMIN, "Администратор");
        rolesUsers.put(Roles.USER, "Пользователь");
        rolesUsers.put(Roles.MODERATOR, "Модератор");
        HashMap<Roles,String> message = new HashMap<>();
        message.put(Roles.ADMIN, "Администрируете систему");
        message.put(Roles.USER, "Используете систему");
        message.put(Roles.MODERATOR, "Следите за порядком");
        System.out.printf("Приветствуем %s с ролью %s, Вы %s", getName(), rolesUsers.get(getRole()), message.get(getRole()));
    }
}

enum Roles {ADMIN, USER, MODERATOR}
