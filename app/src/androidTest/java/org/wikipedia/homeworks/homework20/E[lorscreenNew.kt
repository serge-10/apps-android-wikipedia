package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.DayHeaderCardViewItem
import org.wikipedia.homeworks.homework07.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework07.TopReadItem
import org.wikipedia.homeworks.homework09.InTheNewsViewItem

object ExploreScreenNew : NamedKScreen<ExploreScreenNew>() {
    override val customizeButton: BaseActions
        get() = TODO("Not yet implemented")
    override val searchIcon: BaseAssertions
        get() = TODO("Not yet implemented")
    override val screenName = "Главный экран"
    override fun topReadItemText(): Any {
        TODO("Not yet implemented")
    }

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val toolbarTitle: KImageView by lazy {
        KImageView { withId(R.id.main_toolbar_wordmark) }
            .name(withParent("Заголовок"))
    }
    val feed = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::DayHeaderCardViewItem)
            itemType(::AnnouncementCardViewItem)
            itemType(::TopReadItem)
            itemType(::InTheNewsViewItem)
            itemType(::FeaturedArticleItem)
        }
    ).name(withParent("Список блоков"))

    fun topReadItem(index: Int, function: TopReadItem.() -> Unit) {
        feed.invokeAtIndex(index, function)
    }

    fun topReadItem(): TopReadItem {
        return feed.childWith<TopReadItem> {
            withDescendant {
                withText("Top read")
            }
        }.name(feed.getName().withParent("Top read"))
    }


}