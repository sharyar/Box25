package com.example.box25.adapters


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.box25.R
import com.example.box25.activities.login.SignupActivity
import kotlinx.android.synthetic.main.item_view_pager.view.*

class ViewPagerAdapter (
        val images: List<Int>, val title: List<Int>, val text: List<Int>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]
        val curTitle = title[position]
        val curText = text[position]

        holder.itemView.item_view_pager_image.setImageResource(curImage)
        holder.itemView.item_view_pager_title.setText(curTitle)
        holder.itemView.item_view_pager_text.setText(curText)

        if (position == 2) {
            holder.itemView.onboarding_get_started_button.visibility = View.VISIBLE
            holder.itemView.onboarding_get_started_button.setOnClickListener {
                val context = holder.itemView.context
                val sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("onboarding_complete", true).apply()

//              Finishes current activity and starts the SignupActivity
                val intent = Intent(context, SignupActivity::class.java)
                (context as Activity).finish()
                context.startActivity(intent)
            }
        }
    }
}