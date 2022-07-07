package com.example.homework4_5.presentation

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4_5.R
import com.example.homework4_5.domain.model.Comment
import com.example.homework4_5.domain.model.FeedPost
import com.google.android.material.textview.MaterialTextView
import de.hdodenhof.circleimageview.CircleImageView

class CommentAdapter(private val comment: () -> Unit) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun setComments(comments: List<Comment>) {
        differ.submitList(comments)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_comment_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comm = differ.currentList[position]
        val authorImage = holder.itemView.findViewById<CircleImageView>(R.id.author_image)
        val authorName =
            holder.itemView.findViewById<MaterialTextView>(R.id.author_comment_name_text)
        val comment = holder.itemView.findViewById<MaterialTextView>(R.id.comment_text)

        comment.text = comm.comment
        authorName.text = comm.authorName
        authorImage.setImageResource(comm.authorImage)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

