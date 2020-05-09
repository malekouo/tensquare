import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Test
    public void test1() {
        //创建连接
        MongoClient client = new MongoClient("http://132.232.42.162");
        //打开数据库
        MongoDatabase commentdb = client.getDatabase("commentdb");
        //获取集合
        MongoCollection<Document> comment = commentdb.getCollection("comment");
        //查询
        FindIterable<Document> documents = comment.find();
        //查询记录获取文档集合
        for (Document document : documents) {
            System.out.println("_id：" + document.get("_id"));
            System.out.println("内容：" + document.get("content"));
            System.out.println("用户ID:" + document.get("userid"));
            System.out.println("点赞数：" + document.get("thumbup"));
        }
        //关闭连接
        client.close();
    }
}
