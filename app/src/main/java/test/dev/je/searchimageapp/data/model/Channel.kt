package test.dev.je.searchimageapp.data.model

/**
 * Created by je944 on 2017-10-12.
 */
data class Channel (val result: Int,
                    val pageCount: Int,
                    val item: List<Item>,
                    val lastBuildDate: String,
                    val link: String,
                    val description: String,
                    val generator: String,
                    val title: String,
                    val totalCount: Int)