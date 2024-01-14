package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeholderShock extends AttackSkill {
    public BeholderShock() {
        this.setName("비홀더 쇼크");
        this.setDamage(373.0);          // 쓸컴뱃 기준
        this.setAttackCount(6L);
        this.setCooldown(10.0);
        this.setAddDamage(150L);        // 비홀더-리인포스
        this.addFinalDamage(2.8);
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new BeholderShockDarkWarfare());
        this.setApplyReuse(true);
    }
}
