package com.example.homework4_5.presentation

import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homework4_5.R
import com.example.homework4_5.domain.model.FeedPost
import com.google.android.material.textview.MaterialTextView
import de.hdodenhof.circleimageview.CircleImageView

class FeedAdapter(
    private val likeOnClickListener: (post: FeedPost) -> Unit,
    private val commentOnClickListener: (post: FeedPost) -> Unit
) :
    RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<FeedPost>() {
        override fun areItemsTheSame(oldItem: FeedPost, newItem: FeedPost): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FeedPost, newItem: FeedPost): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)

    fun setPosts(posts: List<FeedPost>) {
        differ.submitList(posts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_feed_post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = differ.currentList[position]

        val authorImage = holder.itemView.findViewById<CircleImageView>(R.id.author_image)
        val authorName = holder.itemView.findViewById<MaterialTextView>(R.id.author_name_text)
        val postImage = holder.itemView.findViewById<ImageView>(R.id.post_image)
        val likeText = holder.itemView.findViewById<MaterialTextView>(R.id.like_count_text)
        val commentCount = holder.itemView.findViewById<MaterialTextView>(R.id.comment_count_text)
        val likeIcon = holder.itemView.findViewById<ImageView>(R.id.like_icon)
        val commentIcon = holder.itemView.findViewById<ImageView>(R.id.comment_icon)

        authorName.text = post.authorName
        authorImage.setImageResource(post.authorImage)
        postImage.setImageResource(post.postImage)
        likeText.text = post.likeCounter.toString()
        commentCount.text = post.comments.size.toString()


        likeIcon.imageTintList = if (post.isLiked) ColorStateList.valueOf(
            ContextCompat.getColor(
                holder.itemView.context,
                R.color.red
            )
        ) else ColorStateList.valueOf(
            ContextCompat.getColor(holder.itemView.context, R.color.black)
        )


        likeIcon.setOnClickListener {
            likeOnClickListener(post)
        }
        commentIcon.setOnClickListener {
            commentOnClickListener(post)
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}

