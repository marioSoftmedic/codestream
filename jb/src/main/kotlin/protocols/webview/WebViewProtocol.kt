package com.codestream.protocols.webview

import com.codestream.models.CodemarkType
import org.eclipse.lsp4j.Range
import protocols.webview.EditorInformation
import protocols.webview.EditorMetrics
import protocols.webview.EditorSelection

interface WebViewNotification {
    fun getMethod(): String
}

object EditorNotifications {

    class DidChangeVisibleRanges(
        val uri: String?,
        val selections: List<EditorSelection>,
        val visibleRanges: List<Range>,
        val lineCount: Number
    ) : WebViewNotification {
        override fun getMethod() = "webview/editor/didChangeVisibleRanges"
    }

    class DidChangeSelection(
        val uri: String?,
        val selections: List<EditorSelection>?,
        val visibleRanges: List<Range>?,
        val lineCount: Number
    ) : WebViewNotification {
        override fun getMethod() = "webview/editor/didChangeSelection"
    }

    class DidChangeActive(val editor: EditorInformation?) : WebViewNotification {
        override fun getMethod() = "webview/editor/didChangeActive"
    }
}

object CodemarkNotifications {

    class Show(
        val codemarkId: String,
        val sourceUri: String?,
        val simulated: Boolean? = null
    ) : WebViewNotification {
        override fun getMethod() = "webview/codemark/show"
    }

    class New(
        val uri: String?,
        val range: Range,
        val type: CodemarkType,
        val source: String?
    ) : WebViewNotification {
        override fun getMethod() = "webview/codemark/new"
    }
}

object StreamNotifications {
    class Show(
        val streamId: String,
        val threadId: String? = null
    ) : WebViewNotification {
        override fun getMethod(): String = "webview/stream/show"
    }
}

object FocusNotifications {
    class DidChange(
        val focused: Boolean
    ) : WebViewNotification {
        override fun getMethod(): String = "webview/focus/didChange"
    }
}

class DidLogout() : WebViewNotification {
    override fun getMethod(): String = "webview/didLogout"
}
