package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EnergyBurst extends AttackSkill {
    public EnergyBurst() {
        this.setName("에너지 버스트");
        this.setDamage(880.0);
        this.setAttackCount(15L);
        this.setCooldown(120.0);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(720L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
