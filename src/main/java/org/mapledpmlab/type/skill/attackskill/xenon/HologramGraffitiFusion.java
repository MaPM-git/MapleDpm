package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.xenon.HologramGraffitiBuff;

public class HologramGraffitiFusion extends AttackSkill {
    public HologramGraffitiFusion() {
        this.setName("홀로그램 그래피티 : 융합");
        this.setAttackCount(5L);
        this.setDamage(550.0);
        this.setDelay(930L);
        this.setCooldown(90.0);
        this.setDotDuration(30000L + 10000);    // 홀로그램 그래피티-퍼시스트
        this.setInterval(220L);
        this.setAddDamage(10L);                 // 홀로그램 그래피티-리인포스
        this.setRelatedSkill(new HologramGraffitiBuff());
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
