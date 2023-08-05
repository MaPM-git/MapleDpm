package org.mapledpmlab.type.skill.buffskill.paladin;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HolyUnity extends BuffSkill {
    public HolyUnity() {
        this.setName("홀리 유니티");
        this.setDescription("" +
                "지속시간 : 45초" +
                "\n딜레이 : 600ms" +
                "\n쿨타임 : 90초" +
                "\n최종데미지 : 100%(코어강화)"
        );
        this.setCooldown(90.0);
        this.setDelay(600L);
        this.setDuration(45L);
        this.setBuffFinalDamage(1.75 + 0.25);   // 코어 강화
    }
}
