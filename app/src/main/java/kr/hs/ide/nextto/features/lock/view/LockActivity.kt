package kr.hs.ide.nextto.features.lock.view

import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kr.hs.ide.nextto.R
import kr.hs.ide.nextto.features.lock.adapter.TipAdapter
import kr.hs.ide.nextto.network.model.tip.Tip


class LockActivity : AppCompatActivity() {

    private val btnLock: View by lazy {
        findViewById(R.id.btn_lock)
    }

    private val rvTip: RecyclerView by lazy {
        findViewById(R.id.rv_tip)
    }

    private lateinit var tipAdapter: TipAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)
        } else {
            this.window.addFlags(
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
            )
        }

        setContentView(R.layout.activity_lock)

        settingAdapter()
        btnLock.setOnClickListener {
            finish()
        }
    }

    private fun settingAdapter() {
        tipAdapter = TipAdapter { link ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(browserIntent)
            finish()
        }
        rvTip.adapter = tipAdapter
        tipAdapter.submitList(listOf(
            Tip(title = "노인맞춤돌봄 특화 서비스", image = "http://www.1661-2129.or.kr/upload/webeditor/20210903180511000325.jpg", link = "http://1661-2129.or.kr/sub02/sub020101_04.do", content = "노인맞춤돌봄 특화서비스는 고독사 및 자살예방을 위해 사회적 고립과 우울 위험이 높은 어르신을 대상으로 맞춤형 사례관리를 제공하여 안정적인 노후생활을 지원하는 서비스입니다."),
            Tip(title = "취약노인보호사업 공모전", image = "http://www.1661-2129.or.kr/upload/webeditor/20220831180743000012.jpg", link = "http://www.1661-2129.or.kr/sub04/sub0402.do", content = "보건복지부장관상 및 기업특별상(한국토지주택공사, 비아트리스) *보건복지부장관상과 기업특별상은 중복하여 수상 가능 부상 제공 * 적합한 수상자가 없는 경우 시상 내역은 변동될 수 있음"),
            Tip(title = "영상으로 만나는 장수학교 영양편", image = "http://www.1661-2129.or.kr/upload/webeditor/20220617135514000092.jpg", link = "https://www.youtube.com/watch?v=yyQr3MFpw4Y", content = "독거노인종합지원센터 장수학교\n" +
                    "노인맞춤돌봄서비스 이용 어르신을 위한 장수노트 교육영상  「장수학교 - 영양편 1편」\n" +
                    ":  노화를 늦추고 면역력을 높이는 식품영양 이야기"),
            Tip(title = "영상으로 만나는 장수학교 건강운동편", image = "http://www.1661-2129.or.kr/upload/webeditor/20220401163341000096.jpg", link = "https://www.youtube.com/playlist?list=PLUMRI_SKefut3uX4mO4bEsc34F81H0o7H", content = "어김없이 찾아오는 봄이 낯설지 않듯\n" +
                    "변해가는 세상도 어르신께 낯설지 않도록\n" +
                    "독거노인종합지원센터는 앞으로도 늘 어르신과 함께 마주 보며 걸어가겠습니다."),
            Tip(title = "종사자 심리상담 * 치료비 지원", image = "http://www.1661-2129.or.kr/upload/webeditor/20220608174429000001.jpg", link = "http://www.1661-2129.or.kr/edu/esub0301_view.do?page_index=1&b_seq=87&b_code=support&b_detail=title&b_search=", content = "심리상담 치료비 지원사업 지원대상 : 업무수행 중 외상경험으로 심리상담 치료를 받은 종사자 상담기관 : 정신건강의학과 병-의원 지원내용 : 1인당 최대 80만원 심리상담 치료비 지원"),
            Tip(title = "손으로 나누는 일상의 위로 온기레터", image = "http://www.1661-2129.or.kr/upload/webeditor/20220803092443000130.jpg", link = "http://scela-ongibox.co.kr/sendletter", content = "STEP 1. 온기레터(고민편지) 작성" +
                    "- 종이에 소중한 고민을 써주세요." +
                    "- 하단에 답장 받으실 주소를 적어 주세요." +
                    "STEP 2. 온기레터(고민편지) 촬영" +
                    "- 작성된 고민편지를 휴대폰으로 촬영해 주세요." +
                    "STEP 3. 온기레터(고민편지) 발송" +
                    "- 촬영한 고민편지를 업로드 해주세요." +
                    "STEP 4. 손편지 답장 기다리기" +
                    "- 3~4주 후에 손편지 답장이 도착할 예정입니다!"),
            Tip(title = "똑똑 생활지원사 교육과정", image = "http://www.1661-2129.or.kr/upload/webeditor/20220817135702000020.jpg", link = "http://www.1661-2129.or.kr/edu/esub0301_view.do?page_index=1&b_seq=103&b_code=edu", content = "인지중재치료, 음악치료, 미술치료, 인지훈련"),
        ))
    }

}