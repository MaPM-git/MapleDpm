package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AnotherBite3 extends AttackSkill {
    public AnotherBite3() {
        this.setName("어나더 바이트(3중첩)");
        this.setAddDamage(30L + 10);        // 아티팩트, 서먼 재규어-인핸스
        this.setDamage(320.0);
        this.setFinalAttack(true);
        this.setAttackCount(3L);
        //this.setCooldown(1.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
