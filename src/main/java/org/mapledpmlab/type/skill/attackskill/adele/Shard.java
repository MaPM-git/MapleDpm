package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Shard extends AttackSkill {
    public Shard() {
        this.setName("샤드");
        this.setDamage(720.0);
        this.setAttackCount(3L);
        this.setCooldown(6.0);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.setApplyReuse(true);
    }
}
