package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossBuff;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LuminousUnion;

import java.util.stream.Collectors;

public class Luminous extends Job {

    public Luminous() {
        // 기본
        super();
        this.setName("루미너스(0초, 리레단일)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2368730.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (400 + 246 + 72 + 274));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (400 + 246 + 72 + 274));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("파워 오브 라이트");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("블레스 오브 다크니스");
        passive.addMagic(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이 위즈덤");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스펠 마스터리");
        passive.addCriticalP(20.0);
        passive.addDamage(15L);
        passive.addMagic(10L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("포틱 메디테이션");
        passive.addMagic(40L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("트와일라잇 노바");
        passive.addFinalDamage(1.41);
        passive.addBossDamage(15L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("다크니스 소서리");
        passive.addProperty(10L);
        passive.addFinalDamage(1.41);
        passive.addIgnoreDefenseList(41L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("매직 마스터리");
        passive.addMagic(31L);
        passive.addCriticalDamage(18.0);
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(0L);
        this.addMainStat(-12L);
        this.addSubStat(5L);

        this.setAbility(new ReuseBossBuff());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new LuminousUnion());
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

        Common doping = new Common();
        doping.setDescription("다크 크레센도");
        doping.addBossDamage(40L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("트와일라잇 노바(콜렉터의 영약)");
        doping.minusFinalDamage(1.41);
        doping.addFinalDamage(1.42);
        doping.addBossDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("다크니스 소서리(콜렉터의 영약)");
        doping.minusFinalDamage(1.41);
        doping.addFinalDamage(1.42);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("매직 마스터리(콜렉터의 영약)");
        doping.addMagic(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("포틱 메디테이션(콜렉터의 영약)");
        doping.addMagic(-40L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
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
