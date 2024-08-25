package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlazingExtinction extends AttackSkill {
    public BlazingExtinction() {
        this.setName("블레이징 익스팅션");
        this.setDamage(1090.0);
        this.setAttackCount(4L + 1);    // 블레이징 익스팅션-애드 어택
        this.setCooldown(10.0);
        this.setDelayByAttackSpeed(870L);
        this.setDotDuration(10000L);
        this.setInterval(990L);
        this.setLimitAttackCount(10L);
        this.setAddDamage(20L);         // 블레이징 익스팅션-리인포스
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
