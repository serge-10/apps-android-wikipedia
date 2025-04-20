package org.wikipedia.homeworks.homework22

import org.wikipedia.R
import org.wikipedia.homeworks.homework07.AnnouncementCardViewItem
import org.wikipedia.homeworks.homework07.SearchCardViewItem
import org.wikipedia.homeworks.homework20.ExploreScreenNew
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.tools.findByID
import org.wikipedia.homeworks.tools.getName
import org.wikipedia.homeworks.tools.invokeByID
import org.wikipedia.homeworks.tools.setName

fun ExploreScreenNew.searchCard(
    targetIndex: Int,
    function: SearchCardViewItem.() -> Unit
) {
    val items = NamedKScreen.items
    val size = items.getSize()

    items.invokeByID<SearchCardViewItem>(
        targetIndex = targetIndex,
        targetID = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = size
    ) {
        setName(items.getName().withParent("Блок поиска"))
        function()
    }
}

fun ExploreScreenNew.getSearchCard(targetIndex: Int = 1): SearchCardViewItem {
    val items = ExploreScreenNew.items
    val size = items.getSize()

    return items.findByID<SearchCardViewItem>(
        targetIndex = targetIndex,
        targetID = R.id.voice_search_button,
        blockName = "Search Card",
        limiter = size
    ).apply {
        setName(items.getName().withParent("Блок поиска"))
    }
}

fun ExploreScreenNew.announcementCard(
    targetIndex: Int,
    function: AnnouncementCardViewItem.() -> Unit
) {
    val items = ExploreScreenNew.items
    val size = items.getSize()

    items.invokeByID<AnnouncementCardViewItem>(
        targetIndex = targetIndex,
        targetID = R.id.view_announcement_header_image,
        blockName = "Announcement Card",
        limiter = size
    ) {
        setName(items.getName().withParent("Блок объявления"))
        function()
    }
}

fun ExploreScreenNew.getAnnouncementCard(targetIndex: Int = 1): AnnouncementCardViewItem {
    val items = ExploreScreenNew.items
    val size = items.getSize()

    return items.findByID<AnnouncementCardViewItem>(
        targetIndex = targetIndex,
        targetID = R.id.view_announcement_header_image,
        blockName = "Announcement Card",
        limiter = size
    ).apply {
        setName(items.getName().withParent("Блок объявления"))
    }
}

fun ExploreScreenNew.searchCardAlone(block: SearchCardViewItem.() -> Unit) {
    getSearchCard().apply(block)
}

fun ExploreScreenNew.announcementCardAlone(block: AnnouncementCardViewItem.() -> Unit) {
    getAnnouncementCard().apply(block)
}

fun ExploreScreenNew.newInTheNewsCard(
    targetIndex: Int,
    function: NewInTheNewsCardItem.() -> Unit
) {
    val items = ExploreScreenNew.items
    val size = items.getSize()

    items.invokeByID<NewInTheNewsCardItem>(
        targetIndex = targetIndex,
        targetID = R.id.news_cardview_recycler_view,
        blockName = "News Card",
        limiter = size
    ) {
        setName(items.getName().withParent("Блок новостей"))
        function()
    }


}
