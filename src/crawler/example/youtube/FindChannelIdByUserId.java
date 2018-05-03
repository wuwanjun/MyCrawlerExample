package crawler.example.youtube;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;

/**
 * 透過 userid 找出相關的 channels
 */
public class FindChannelIdByUserId {

    public static void main(String[] args) {
        CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

        String api_key = "AIzaSyCE3rhrAg9_Nuxr1i-lfwTnbZ48ECkc-9c";
        String channel = "UCnnp2fWa77PP2h08T7WAzzw";

        // 遠端資料路徑
        String uri = "https://www.googleapis.com/youtube/v3/search?channelId=" +channel+
                "&part=snippet,id&order=date&maxResults=50" +
                "&fields=items(id(videoId),snippet(title))"+
                "&key="+api_key;

        System.out.println(
            CrawlerPack.start()
                .getFromJson(uri)
                .select("items")

        );
    }
}
