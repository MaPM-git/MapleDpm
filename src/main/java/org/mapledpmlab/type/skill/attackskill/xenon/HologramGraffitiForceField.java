package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HologramGraffitiForceField extends AttackSkill {
    public HologramGraffitiForceField() {
        this.setName("홀로그램 그래피티 : 역장");
        this.setAttackCount(1L);
        this.setDamage(1000.0);
        this.setDelay(930L);
        this.setCooldown(60.0);
        this.setDotDuration(60000L + 10000);    // 홀로그램 그래피티-퍼시스트
        this.setInterval(250L);
        this.setAddDamage(10L);                 // 홀로그램 그래피티-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
