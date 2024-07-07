package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ScatteringShotEnchant extends AttackSkill {
    public ScatteringShotEnchant() {
        this.setName("[발현] 스캐터링 샷");
        this.setDamage(750.0);
        this.setAttackCount(4L * 7);
        this.setDelayByAttackSpeed(630L);
        this.setCooldown(6.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
        this.addFinalDamage(4.0 / 7);
        this.setApplyReuse(true);
    }
}
