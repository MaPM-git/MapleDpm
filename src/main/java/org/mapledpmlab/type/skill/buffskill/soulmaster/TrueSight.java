package org.mapledpmlab.type.skill.buffskill.soulmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TrueSight extends BuffSkill {
    public TrueSight() {
        this.setName("트루 사이트");
        this.setDelay(600L);
        this.setDuration(30L + 20);             // 트루 사이트-퍼시스트
        //this.setCooldown(30.0 + 20);
        this.addBuffIgnoreDefense(10L + 10);    // 트루 사이트-이그노어 가드
        this.addBuffFinalDamage(1.15);          // 트루 사이트-인핸스
    }
}
