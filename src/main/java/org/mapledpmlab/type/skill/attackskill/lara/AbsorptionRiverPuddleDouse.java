package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbsorptionRiverPuddleDouse extends AttackSkill {
    public AbsorptionRiverPuddleDouse() {
        this.setName("흡수 : 강 웅덩이 물벼락");
        this.setDamage(717.0);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(2.5);
        this.setAddDamage(10L + 15);    // 분출/흡수 - 리인포스, 보스 킬러
        this.addFinalDamage(1.20);      // 용맥 분출 VI
        this.addFinalDamage(1.15);      // 잠 깨우기 VI
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
