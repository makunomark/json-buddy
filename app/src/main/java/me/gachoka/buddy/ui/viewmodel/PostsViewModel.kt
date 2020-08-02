package me.gachoka.buddy.ui.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import me.gachoka.buddy.data.local.entity.PostEntity
import me.gachoka.buddy.data.repository.PostRepository

class PostsViewModel
@ViewModelInject constructor(
    private val postRepository: PostRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _posts: MutableLiveData<List<PostEntity>> = MutableLiveData()

    val posts: LiveData<List<PostEntity>> get() = _posts

    init {
        getLocalPosts()
    }

    fun getRemotePosts() {
        postRepository.getRemotePosts {
            viewModelScope.launch {
                postRepository.savePosts(*it)
                getLocalPosts()
            }
        }
    }

    private fun getLocalPosts() {
        viewModelScope.launch {
            val localPosts = postRepository.getLocalPosts()
            _posts.postValue(localPosts)
        }
    }
}
