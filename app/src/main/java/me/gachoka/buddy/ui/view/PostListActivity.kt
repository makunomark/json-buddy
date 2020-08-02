package me.gachoka.buddy.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_post_list.*
import me.gachoka.buddy.R
import me.gachoka.buddy.ui.viewmodel.PostsViewModel

@AndroidEntryPoint
class PostListActivity : AppCompatActivity() {

    private val postsViewModel: PostsViewModel by viewModels()

    private val postListAdapter: PostListAdapter = PostListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        setUpViews()
    }

    private fun setUpViews() {
        recyclerViewPosts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewPosts.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        recyclerViewPosts.adapter = postListAdapter
    }

    override fun onStart() {
        super.onStart()
        postsViewModel.posts.observe(this, Observer {
            postListAdapter.postList = it
            postListAdapter.notifyDataSetChanged()
        })
    }

    override fun onResume() {
        super.onResume()
        postsViewModel.getRemotePosts()
    }
}
