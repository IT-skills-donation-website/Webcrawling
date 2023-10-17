package com.example.Crawling.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/") // 일단 local로
public class WebCrawlerController {

    @GetMapping
    public String crawlData(Model model) {
        try {
            String url = "https://www.1365.go.kr/vols/1572247904127/partcptn/timeCptn.do";

            Document doc = Jsoup.connect(url).get();

            Elements h3Elements = doc.select("dt.txts,dt.tit_board_list"); // li, h3.tit_board_view(특정 봉사) dt.클래스이름 중

            List<String> crawledData = new ArrayList<>();

            for (Element h3Element : h3Elements) {
                String title = h3Element.text();
                crawledData.add(title);
            }

            model.addAttribute("crawledData", crawledData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "scrapedData";
    }
}
