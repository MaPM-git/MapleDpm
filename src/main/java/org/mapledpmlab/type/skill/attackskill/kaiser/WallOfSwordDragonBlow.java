package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WallOfSwordDragonBlow extends AttackSkill {
    public WallOfSwordDragonBlow() {
        this.setName("윌 오브 소드(드래곤 블로우)");
        this.setDamage(3800.0);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
