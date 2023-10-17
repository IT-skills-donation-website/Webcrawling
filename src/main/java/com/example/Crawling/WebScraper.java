package com.example.Crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScraper {
    public static void main(String[] args) {
        // 웹 드라이버 경로 설정
        System.setProperty("webdriver.chrome.driver", "경로/chromedriver.exe");

        // WebDriver 초기화
        WebDriver driver = new ChromeDriver();

        try {
            // 1365 사이트로 이동
            driver.get("https://www.1365.go.kr/vols/search.do");

            // 검색어 입력
            WebElement searchField = driver.findElement(By.id("realQuery"));
            searchField.sendKeys("스크레이핑"); // 원하는 검색어로 변경

            // 검색 버튼 클릭
            WebElement searchButton = driver.findElement(By.id("searchBtn"));
            searchButton.click();

            // 검색 결과 가져오기 (예시: 제목)
            WebElement resultsContainer = driver.findElement(By.id("content"));
            WebElement titleElement = resultsContainer.findElement(By.tagName("h3"));
            String title = titleElement.getText();
            System.out.println("검색 결과: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
    }
}
