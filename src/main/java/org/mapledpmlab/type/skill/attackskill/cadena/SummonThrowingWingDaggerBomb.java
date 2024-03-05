package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonThrowingWingDaggerBomb extends AttackSkill {
    public SummonThrowingWingDaggerBomb() {
        this.setName("서먼 스로잉 윙대거(폭발)");
        this.setDamage(450.0 + 100 + 177);
        this.setAttackCount(3L);
        this.setCooldown(10.0);
        this.setApplyReuse(true);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
        this.setRelatedSkill(new SummonThrowingWingDagger());
    }
}
