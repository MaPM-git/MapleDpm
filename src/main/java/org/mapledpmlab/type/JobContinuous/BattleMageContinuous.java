package org.mapledpmlab.type.JobContinuous;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class BattleMageContinuous extends Job {

    public BattleMageContinuous() {
        // 기본
        super();
        this.setName("배틀메이지(컨티)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        //this.addBossDamage(70L);
        //this.addMagicP(9L);
        this.addBossDamage(30L);
        this.addMagicP(21L);
        this.addMagicP(21L);

        // 1차
        this.addMagic(20L);             // 아트 오브 스태프
        this.addCriticalP(15.0);

        // 2차
        this.addMagic(30L);             // 스태프 마스터리
        this.addCriticalP(20.0);
        this.addMainStat(40L);          // 하이 위즈덤

        // 3차
        this.addFinalDamage(1.3);       // 배틀 마스터리
        this.addCriticalDamage(15.0);

        // 4차
        this.addMagicP(15L);            // 다크 오라
        this.addDamage(10L);
        this.addBossDamage(5L);
        this.addDamage(25L);            // 배틀 레이지
        this.addCriticalP(21.0);
        this.addCriticalDamage(10.0);
        this.addMagic(31L);             // 스태프 엑스퍼트
        this.addCriticalDamage(21.0);
        this.addFinalDamage(1.22);      // 스펠 부스트
        this.addMagicP(10L);
        this.addDamage(16L);
        this.addIgnoreDefenseList(31L);

        // 환산 보정
        this.addMainStatP(12L);
        this.addMainStat(-3L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addIgnoreDefenseList(20L);     // 디버프 오라
        this.addFinalDamage(1.05);
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
