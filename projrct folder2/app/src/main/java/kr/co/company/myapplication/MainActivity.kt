package kr.co.company.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById(R.id.textView) as TextView

        textView.text = ""

        var thread = NetworkThread()
        thread.start()
    }

    inner class NetworkThread : Thread(){
        override fun run() {
            try{
                var site = "https://api.odcloud.kr/api/15096810/v1/uddi:7f9a9364-8486-447d-9864-c3eb575e540b?page=1&perPage=10&returnType=XML&serviceKey=MQEi8wbM%2FhBUMFBZYB5nAzoaENMaHEyYy1dF6EDnvRNI8YyptFrbwo5ARvZsHKFkWfvHWYd57TjZQOX9N6Qw1g%3D%3D"
                var url = URL(site)
                var conn = url.openConnection()
                var input = conn.getInputStream()

                var factory = DocumentBuilderFactory.newInstance()
                var builder = factory.newDocumentBuilder()
                var doc = builder.parse(input)

                var root = doc.documentElement //전체 xml가져옴

                var item_node_list = root.getElementsByTagName("item") //xml item list 가져옴
                for(i in 0 until item_node_list.length){

                    var item_element = item_node_list.item(i) as org.w3c.dom.Element
                    var data1_node_list = item_element.getElementsByTagName("col")

                    for(j in 0 until 9){
                        //var data1_node_list = item_element.getElementsByTagName("col")
                        var data1_node = data1_node_list.item(j) as org.w3c.dom.Element
                        var data1 = data1_node.textContent
                        runOnUiThread {
                            var textView = findViewById(R.id.textView) as TextView
                            textView.append("${data1}\n")
                        }
                    }
                }

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}