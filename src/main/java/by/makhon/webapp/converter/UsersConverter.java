package by.makhon.webapp.converter;

import by.makhon.webapp.bean.Users;
import by.makhon.webapp.dto.UsersDTO;

public class UsersConverter {
    public UsersDTO convertToDTO(Users user) {
        UsersDTO userDTO = new UsersDTO();

        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}