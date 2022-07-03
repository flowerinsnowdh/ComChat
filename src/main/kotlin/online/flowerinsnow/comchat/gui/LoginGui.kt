package online.flowerinsnow.comchat.gui

import online.flowerinsnow.comchat.util.DimensionUtils
import online.flowerinsnow.comchat.util.UnicodeUtils
import java.awt.Color
import java.awt.event.FocusAdapter
import java.awt.event.FocusEvent
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JProgressBar
import javax.swing.JTabbedPane
import javax.swing.JTextField

class LoginGui : JFrame() {
    fun init() {
        initFrame()
        initComponents()
        initListeners()
        isVisible = true // 显示Gui
    }



    private val tabs = JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT)
    private val container = contentPane

    private val tabClient = JPanel(null)
    private val tabServer = JPanel(null)

    private val clientIP = JTextField("连接IP")
    private var clientIPEmpty = true
    private val clientPasswordPH = JTextField("密码（无密码请留空）")
    private val clientPassword = JPasswordField()
    private val clientConfirm = JButton("连接")
    private val clientProgress = JProgressBar()
    
    private val serverPort = JTextField("开放端口 [32045]")
    private var serverPortEmpty = true
    private val serverPasswordPH = JTextField("设置密码 [留空]")
    private val serverPassword = JPasswordField()
    private val serverConfirm = JButton("开始")

    private fun initFrame() {
        title = "登录"
        setSize(DimensionUtils.widthOfScreen(0.5F), DimensionUtils.heightOfScreen(0.5F)) // 自适应宽高
        setLocationRelativeTo(null) // 居中窗口
        defaultCloseOperation = EXIT_ON_CLOSE // 临时测试用
    }

    private fun initComponents() {
        sizeComponents()



        tabClient.add(clientIP)

        tabClient.add(clientPasswordPH)

        clientPassword.isVisible = false
        tabClient.add(clientPassword)

        clientConfirm.background = Color.GREEN
        tabClient.add(clientConfirm)

        clientProgress.isStringPainted = true
        clientProgress.string = ""
        tabClient.add(clientProgress)

        tabServer.add(serverPort)

        tabServer.add(serverPasswordPH)

        serverPassword.isVisible = false
        tabServer.add(serverPassword)

        serverConfirm.background = Color.GREEN
        tabServer.add(serverConfirm)

        tabs.addTab("连接", tabClient)
        tabs.addTab("开服", tabServer)
        container.add(tabs)
    }

    private fun sizeComponents() {
        val eightOfWidth = DimensionUtils.sizeOf(this.width, 0.125F)
        val fiveOfHeight = DimensionUtils.sizeOf(this.height, 0.2F)
        val heightPer = DimensionUtils.sizeOf(this.height, 0.08F)
        val absSepc = 5

        clientIP.setBounds(eightOfWidth, fiveOfHeight, eightOfWidth * 6, heightPer)
        clientPasswordPH.setBounds(eightOfWidth, fiveOfHeight + heightPer + absSepc, eightOfWidth * 6, heightPer)
        clientPassword.setBounds(eightOfWidth, fiveOfHeight + heightPer + absSepc, eightOfWidth * 6, heightPer)
        clientConfirm.setBounds(eightOfWidth, fiveOfHeight + (heightPer + absSepc) * 2, eightOfWidth * 6, heightPer)
        clientProgress.setBounds(eightOfWidth, fiveOfHeight + (heightPer + absSepc) * 3, eightOfWidth * 6, heightPer)

        serverPort.setBounds(eightOfWidth, fiveOfHeight, eightOfWidth * 6, heightPer)
        serverPasswordPH.setBounds(eightOfWidth, fiveOfHeight + heightPer + absSepc, eightOfWidth * 6, heightPer)
        serverPassword.setBounds(eightOfWidth, fiveOfHeight + heightPer + absSepc, eightOfWidth * 6, heightPer)
        serverConfirm.setBounds(eightOfWidth, fiveOfHeight + (heightPer + absSepc) * 2, eightOfWidth * 6, heightPer)
    }

    private fun initListeners() {
        // clientIP输入框的占位符监听器
        clientIP.addFocusListener(object : FocusAdapter() {
            override fun focusGained(e : FocusEvent) {
                if (clientIPEmpty) {
                    clientIP.text = ""
                }
            }

            override fun focusLost(e : FocusEvent) {
                clientIPEmpty = clientIP.text.trim() == ""
                if (clientIPEmpty) {
                    clientIP.text = "连接IP"
                }
            }
        })

        // clientPassword密码框的占位符监听器
        clientPasswordPH.addFocusListener(object : FocusAdapter() {
            override fun focusGained(e : FocusEvent) {
                clientPasswordPH.isVisible = false
                clientPassword.isVisible = true
                clientPassword.requestFocus()
            }
        })

        // clientPassword密码框的占位符监听器
        clientPassword.addFocusListener(object : FocusAdapter() {
            override fun focusLost(e : FocusEvent) {
                if (clientPassword.password.isEmpty()) {
                    clientPasswordPH.isVisible = true
                    clientPassword.isVisible = false
                }
            }
        })

        // serverPort输入框的占位符监听器
        serverPort.addFocusListener(object : FocusAdapter() {
            override fun focusGained(e : FocusEvent) {
                if (serverPortEmpty) {
                    serverPort.text = ""
                }
            }

            override fun focusLost(e : FocusEvent) {
                serverPortEmpty = serverPort.text.trim() == ""
                if (serverPortEmpty) {
                    serverPort.text = "开放端口 [32045]"
                }
            }
        })

        // serverPort只允许输入数字，并且最多五位
        serverPort.addKeyListener(object : KeyAdapter() {
            override fun keyTyped(e : KeyEvent) {
                if (serverPort.text.length > 4 || !UnicodeUtils.isNumber(e.keyChar)) {
                    e.consume()
                }
            }
        })

        // serverPassword密码框的占位符监听器
        serverPasswordPH.addFocusListener(object : FocusAdapter() {
            override fun focusGained(e : FocusEvent) {
                serverPasswordPH.isVisible = false
                serverPassword.isVisible = true
                serverPassword.requestFocus()
            }
        })

        // serverPassword密码框的占位符监听器
        serverPassword.addFocusListener(object : FocusAdapter() {
            override fun focusLost(e : FocusEvent) {
                if (serverPassword.password.isEmpty()) {
                    serverPasswordPH.isVisible = true
                    serverPassword.isVisible = false
                }
            }
        })
    }
}