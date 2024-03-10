package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Tread extends AttackSkill {
    public Tread() {
        this.setName("트레드");
        this.setDamage(815.0);
        this.setDelayByAttackSpeed(840L);
        this.setAttackCount(6L);
        this.setCooldown(1.5);
        this.setDotDuration(60000L);
        this.setInterval(1020L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 트리거-리인포스, 보스 킬러
        this.setApplyReuse(true);
    }
}
