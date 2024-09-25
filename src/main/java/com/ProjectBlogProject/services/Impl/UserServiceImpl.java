package com.ProjectBlogProject.services.Impl;

import com.ProjectBlogProject.entity.User;
import com.ProjectBlogProject.exception.ResourceNotFoundException;
import com.ProjectBlogProject.playloads.UserDto;
import com.ProjectBlogProject.repository.UserRepository;
import com.ProjectBlogProject.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.DtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow
                (()-> new ResourceNotFoundException
                        ("User", "Id", userId));
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setId(userDto.getId());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        User updateUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(updateUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow
                (()-> new ResourceNotFoundException
                        ("user", "id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> user = this.userRepository.findAll();
        List<UserDto> userDtos=user.stream().
                map(this::userToDto).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).
                orElseThrow(()-> new ResourceNotFoundException
                        ("user", "id", userId));
        this.userRepository.deleteById(userId);

    }
    private User DtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userdto = new UserDto();
        userdto.setId(userdto.getId());
        userdto.setName(userdto.getName());
        userdto.setAbout(userdto.getAbout());
        userdto.setEmail(userdto.getEmail());
        userdto.setPassword(userdto.getPassword());
        return userdto;
    }
}
