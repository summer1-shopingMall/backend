package com.example.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User implements UserDetails {
  //UserDetails interface를 User에서 구현한다.
  //UserDetails는 UserDetailService를 통해 입력된 로그인 정보와 DB에 저장된 사용자 정보를 가져오는 역할을 수행한다.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true)
  private String userId;

  @NotNull
  private String userName;

  @NotNull
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @NotNull
  @Column(unique = true)
  private String email;

  @NotNull
  private String type;
  //네이버인지 구글인지 카카오인지 회원가입 타입 결정

  private long address1;

  private long address2;

  private long address3;

  @NotNull
  @Column(unique = true)
  private String phone;

  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> roles = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    //계정이 가지고 있는 권한 목록을 리턴한다.
    return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
  }

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Override
  public String getPassword() {
    //계정의 비밀번호를 리턴한다.
    return this.password;
  }

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Override
  public String getUsername() {
    //계정의 이름을 리턴, 일반적으로는 아이디를 리턴한다.
    return this.userId;
  }

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Override
  public boolean isAccountNonExpired() {
    //계정이 만료됐는지 여부를 리턴(true: 만료x)
    return true;
  }

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Override
  public boolean isAccountNonLocked() {
    //계정이 잠겨인는지 여부를 리턴(true: 잠겨있지x)
    return true;
  }

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Override
  public boolean isCredentialsNonExpired() {
    //비밀번호가 만료됐는지 여부를 리턴(true: 만료x)
    return true;
  }

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Override
  public boolean isEnabled() {
    //계정이 활성화돼있는지 여부를 리턴(true: 활성화상태)
    return true;
  }

}
