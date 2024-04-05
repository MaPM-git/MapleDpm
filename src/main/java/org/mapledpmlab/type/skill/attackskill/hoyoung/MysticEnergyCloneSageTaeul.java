package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MysticEnergyCloneSageTaeul extends AttackSkill {
    public MysticEnergyCloneSageTaeul() {
        this.setName("선기 : 분신 둔갑 태을선인");
        this.setDamage(800.0);
        this.setDelayByAttackSpeed(720L);
        this.setAttackCount(8L);
        this.setCooldown(180.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
