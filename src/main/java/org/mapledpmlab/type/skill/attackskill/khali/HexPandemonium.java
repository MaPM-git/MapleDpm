package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexPandemonium extends AttackSkill implements HexSkill {
    public HexPandemonium() {
        this.setName("헥스 : 판데모니움");
        this.setDamage(715.0);
        this.setAttackCount(4L);
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(600L);
        this.setRelatedSkill(new HexPandemoniumFinish());
        this.addFinalDamage(1.6);   // 코어강화
        this.setAddDamage(20L + 20);    // 헥스-보스 킬러, 리인포스
        this.getMultiAttackInfo().add(300L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
