package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Territory extends AttackSkill {
    public Territory() {
        this.setName("테리토리");
        this.setDamage(700.0);
        this.setAttackCount(4L);
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(540L);
        this.setDotDuration(7000L + 4000);
        this.setInterval(350L);
        this.setLimitAttackCount(27L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyReuse(true);
    }
}
