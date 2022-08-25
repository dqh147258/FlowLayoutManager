package com.yxf.flowlayoutmanagersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yxf.flowlayoutmanager.FlowLayoutManager
import com.yxf.flowlayoutmanagersample.databinding.ActivityMainBinding
import com.yxf.flowlayoutmanagersample.databinding.ItemFlowBinding

class MainActivity : AppCompatActivity() {

    private class ViewHolder(val binding: ItemFlowBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    private val vb by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }

    private val valueList = listOf<String>(
        "测试", "测试测试", "测试测试测试测试", "测试测试", "测试测试测试测试测试测试测试测试",
        "测试", "测试试", "试测试测试", "测试测试", "测试测试测试测试试测试", "测试", "测试测试", "测试测试测试", "测试测试", "测试测试测试测试测试测试",
        "测试测试测试测试试测试", "测试", "测试测试", "测试测试测试", "测试测试",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(vb.root)
        vb.recyclerView.run {
            adapter = object : RecyclerView.Adapter<ViewHolder>() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                    val binding = ItemFlowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    return ViewHolder(binding)
                }

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                    holder.binding.root.text = valueList[position]
                }

                override fun getItemCount(): Int {
                    return valueList.size
                }

            }
            layoutManager = FlowLayoutManager()
        }


    }
}