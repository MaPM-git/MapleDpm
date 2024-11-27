package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonChain extends AttackSkill {
    public PoisonChain() {
        this.setName("포이즌 체인");
        this.setDamage(550.0);
        this.setCooldown(25.0);
        this.setAttackCount(4L);
        this.setDelay(780L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}