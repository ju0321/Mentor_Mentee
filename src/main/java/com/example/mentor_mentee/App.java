package com.example.mentor_mentee;


import com.example.mentor_mentee.global.config.AppConfig;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class App {

  private final String appName;

  /*@Autowired
  public App(String appName) {
    this.appName = appName;
  }*/

  public static void main(String[] args) {
    // 스프링 컨테이너를 불러오는데, AppConfig와 App 클래스에 대해 등록하는 컨테이너 불러오기
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, App.class);
    //Bean 창고에서 객체를 꺼내오는 역할을 함


    App app = ac.getBean(App.class);
    System.out.println(app.getAppName());

    // String 타입으로 등록된 모든 Bean 조회
    Map<String, String> beansOfType = ac.getBeansOfType(String.class);
    for(String key : beansOfType.keySet()) {
      System.out.println("key = " + key + ", bean = " + beansOfType.get(key));
    }
  }

}