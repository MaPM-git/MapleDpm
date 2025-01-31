package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbsorptionSunlitightGrain extends AttackSkill {
    public AbsorptionSunlitightGrain() {
        this.setName("흡수 : 햇빛 맹아리");
        this.setDamage(380.0);
        this.setAttackCount(6L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(2.5);
        this.setDotDuration(1000L);
        this.setInterval(90L);
        this.setLimitAttackCount(5L);
        this.setAddDamage(10L + 15);    // 분출/흡수 - 리인포스, 보스 킬러
        this.addFinalDamage(1.20);      // 용맥 분출 VI
        this.addFinalDamage(1.15);      // 잠 깨우기 VI
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
