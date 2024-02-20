package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class Requiem extends GaugeAttackSkill {
    public Requiem() {
        this.setName("레퀴엠");
        this.setDelay(3600L);
        this.setAttackCount(10L);
        this.setDamage(1200.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.setCooldown(360.0);
        this.setGaugePer(-15L);
        this.setRelatedSkill(new RequiemDemonSword());
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(120L);    // 1
        this.getMultiAttackInfo().add(90L);     // 2
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);     // 5
        this.getMultiAttackInfo().add(420L);    // 6
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);     // 8
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);     // 11
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);     // 22
        this.getMultiAttackInfo().add(480L);    // 23
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);     // 26
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);     // 32
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
