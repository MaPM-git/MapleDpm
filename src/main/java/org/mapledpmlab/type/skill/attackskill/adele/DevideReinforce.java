package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DevideReinforce extends AttackSkill {
    public DevideReinforce() {
        this.setName("디바이드(강화)");
        this.setDamage(570.0 + 40);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(7L);
        this.setCooldown(6.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 트리거-리인포스, 보스 킬러
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
