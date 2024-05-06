package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AnotherBite3 extends AttackSkill {
    public AnotherBite3() {
        this.setName("어나더 바이트(3중첩)");
        this.setAddDamage(25L + 10);        // 농장, 서먼 재규어-인핸스
        this.setDamage((70.0 + 15 + 15 + 20 + 40) * 3);
        this.setFinalAttack(true);
        this.setAttackCount(1L);
        //this.setCooldown(1.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
