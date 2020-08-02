package me.gachoka.buddy.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import me.gachoka.buddy.R
import me.gachoka.buddy.data.local.entity.PostEntity

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    var postList: List<PostEntity>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitle = itemView.findViewById<AppCompatTextView>(R.id.textViewTitle)
        private val textViewBody = itemView.findViewById<AppCompatTextView>(R.id.textViewBody)

        fun bind(postEntity: PostEntity) {
            textViewBody.text = postEntity.body
            textViewTitle.text = postEntity.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return postList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        postList?.get(position)?.let { holder.bind(it) }
    }
}
